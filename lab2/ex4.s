.data



.macro push rX                   		# creating a macro which wraps the two instructions for pushing into the stack
    subi	sp,	sp,	4
    stw     \rX,    (sp)
.endm

.macro pop rX                    		# creating a macro which wraps the two instructions for poping from the stack
    ldw	    \rX,    (sp)
    addi	sp,	sp,	4 
.endm    

.global _start
.text

_start:
    movi	r10,    0               # r10 will store the value which will be passed to the write_led function
    movi    r11,	1               # r11 is used to compare the retrun value of the functions read_key0/1

loop:
    call read_KEY0                          # read the most left button and stores 1 into r2 if it's pressed, 0 if not
    
    beq	r2,	r11,    incNum          # jump to incNum if the most left button is pressed

backFromIncrement:

    call read_KEY3                          # read the most right button and stores 1 into r2 if it's pressed, 0 if not

    beq r2,	r11,    resetNum        # jump to resetNum if the most right button is pressed

backFromReset:

    mov		r4,		r10                 # stores the value which will be passed to the leds into r4 because of ABI
    push	r4                          # pushes the value into t the stack

call write_LED

br loop


incNum:
addi    r10,    r10,    1   # increment r10 by 1
br backFromIncrement                    # returns to the main loop


resetNum:
movi    r10,    0               # resets r10
br backFromReset                        # returns to the main loop


read_KEY0:                              # a function which reads the state of the most left button
movui r2, 0x840                         # stores the address of all the buttons into r2
ldb	r2,	(r2)                            # get the value stored in r2 back to r2
andi    r2,	r2,	1                       # ands the value of r2 because the function should return either 1 or 0(discards all the bits except the first one)
ret                                     # returns to the main function

read_KEY3:                              # a function which reads the state of the most right button
movui r2, 0x840                         # stores the address of all the buttons into r2
ldb	r2,	(r2)                            # get the value stored in r2 back to r2
srli    r2,	r2,	3                       # shifts r2 by 3 bits to the right, so we get only the 4th bit which corresponds to the most right button
ret

.global write_LED                       # function which will light an LED/S depending on the value of the given argument
write_LED:
pop r8                                  # getting the value from the stack into r8
movui   r9, 0x810                       # moving the address of the LEDS to r9
stw	    r8, (r9)                        # writing the value of r8 into the the address of the LEDS
ret                                     # returing back to the main function


endloop:
    br endloop
    .end
