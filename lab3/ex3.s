.data

sentence: .ascii "kurvi belo i kosinusi"

.macro push rX                   # creating a macro which wraps the two instructions for pushing into the stack
    subi	sp,	sp,	4
    stw     \rX,    (sp)
.endm

.macro pop rX                    # creating a macro which wraps the two instructions for poping from the stack
    ldw		\rX,    (sp)
    addi	sp,	sp,	4 
.endm    

.global _start
.text

_start:
    movia r5, sentence
    call sendString0
br endloop

sendString0:
    push r31                    # saves the return address into stack, because we are calling subroutine in subroutine, this results in losing the first return address
    movui r8, 0x864             # Storing the address of TxData into r8
    movui r9, 0x868             # Storing the address of TxReady into r9
    loop:
        ldbu r10, (r5)          # loads the next letter in the string
        beq r10, r0, restore    # checks if the letter is null and jumps if so
        mov r4, r10             # moves the letter for the sendChar0 function
        call sendChar0          # calls the function  
        addi r5, r5, 1          # increments r5(the address of the current letter in memory) by 1, this results in r5 pointing to the next letter
    br loop

    restore:    
    movi r4, 10                 # moves the LN(new line) character into r4 for sendChar0 func
    call sendChar0              # calls sentChar0
    pop r31                     # restores the return address for the first function call
ret

sendChar0:
    
    stb r4,(r8)                 # sending the character in r4 to TxData(0x864)
    waitForTransmission:
    ldbu r10, (r9)              # loading the value of the byte which contains RxReady and TxReady into r10
    srli r10, r10, 6            # getting rid of the first six least significant bits, because they are not used(shifing 6 bits)
    andi r10, r10, 1            # AND-ing to extract only TxReady bit, because RxReady is right next to it
    bne r10, r0, sent           # jump to end of function if TxReady is 1 (that means the byte was sent)
    br waitForTransmission
    sent:
ret

endloop:
    br endloop
    .end