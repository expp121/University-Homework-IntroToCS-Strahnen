.data

.macro push rX                   # creating a macro which wraps the two instructions for pushing into the stack
    subi sp, sp, 4
    stw \rX, (sp)
.endm

.macro pop rX                    # creating a macro which wraps the two instructions for poping from the stack
    ldw \rX, (sp)
    addi sp, sp, 4 
.endm    

.global _start
.text

_start:
    movi r10, 0                         # r10 will store the value which will be passed to the write_led function
    movi r11, 1                         # r11 is used to compare the retrun value of the functions read_key0/1
    movi r12, 0                         # r12 will hold if the buttons is pressed

loop:
    call read_KEY0                      # read the most left button and stores 1 into r2 if it's pressed, 0 if not

    beq	r2, r11, incNum                 # jump to incNum if the most left button is pressed
    movi r12, 0                         # reseting the flag to 0 if the button is not pressed
    backFromIncrement:

    call read_KEY3                      # read the most right button and stores 1 into r2 if it's pressed, 0 if not

    beq r2, r11, resetNum               # jump to resetNum if the most right button is pressed

    backFromReset:
    mov r4, r10                         # stores the value which will be passed to the leds into r4 because of ABI
    call write_LED                      # calls the function which turns the corresponding LEDs
    andi r10, r10, 15                   # anding the counter with 1111(15), that doesn't allow exceeding 15, that's done because the max value of the LEDs is 15
br loop

incNum:
    bne r12, r0, backFromIncrement      # getting back to main function if the flag is 1
    movi r12, 1                         # setting the flag to 1
    addi r10, r10, 1                    # increment r10 by 1
br backFromIncrement                    # returns to the main loop

resetNum:
    movi r10, 0                         # resets r10
br backFromReset                        # returns to the main loop

read_KEY0:                              # a function which reads the state of the most left button
    movui r2, 0x840                     # stores the address of all the buttons into r2
    ldb	r2,	(r2)                        # get the value stored in r2 back to r2
    andi r2, r2, 1                      # ands the value of r2 because the function should return either 1 or 0(discards all the bits except the first one)
ret                                     # returns to the main function

read_KEY3:                              # a function which reads the state of the most right button
    movui r2, 0x840                     # stores the address of all the buttons into r2
    ldb	r2,	(r2)                        # get the value stored in r2 back to r2
    srli r2, r2, 3                      # shifts r2 by 3 bits to the right, so we get only the 4th bit which corresponds to the most right button
ret

write_LED:
    push r31                            # function which will light an LED/S depending on the value of the given argument
    movui r9, 0x810                     # moving the address of the LEDS to r9
    stw	r4, (r9)                        # writing the value of r4 into the the address of the LEDS
    call decToAscii                     # calls the DECIMAL TO ASCII function(return in r2,r3)
    beq r3, r0, small                   # jump to small if the number we gave to the function is smaller than 10
    mov r4, r3                          # prepares the 10th's for function argument
    mov r8, r2                          # saves the remainder into r8
    movi r5, 0x860                      # that's the starting address of the UART0
    call nr_uart_txchar                 # sends the 10th's number to the UART
    mov r4, r8                          # prepares the remainder for function argument
    movi r5, 0x860                      # that's the starting address of the UART0
    call nr_uart_txchar                 # sends the remainder's number to the UART
    br endWL

    small:
    mov r4, r2                          # prepares the remainder for function argument
    movi r5, 0x860                      # that's the starting address of the UART0
    call nr_uart_txchar                 # sends the remainder's number to the UART

    endWL:
    movi r4, 32                         # ascii code of ' ' (Space)
    movi r5, 0x860              
    call nr_uart_txchar                 # sends 'space' to the uart    
    pop r31

ret                                     # returing back to the main function

decToAscii:                             # returns a number converted from decimal to ascii, if the number is bigger that 9, the 10th's are returned in r3
    movi r8, 10                         # moves 10 into r8(it wil lbe used to divide the number by 10)
    div r3, r4, r8                      # divide the number by then and save the whole part into r3
    mul r2, r3, r8                      # multiply the whole part by 10 and save it into r2
    sub r2, r4, r2                      # subtract the multiplied whole part by the given number(gets the remainder) and save it in r2
    addi r2,r2, 48                      # convert the remainder into ascii number
    beq r3, r0, converted               # jump to converted if the number is smaller then 10
    addi r3,r3, 48                      # converts the 10th's into ascii number
converted:
ret

endloop:
    br endloop
    .end