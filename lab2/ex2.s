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
    movui   r4, 0b0100                  # Setting which LEDS will be on by moving a value from 0 to 15 into r4    
    push r4                             # pushing the value of r4 into the stack
    call    write_LED                   # calling the LED function

    br endloop


.global write_LED                       # function which will light an LED/S depending on the value of the given argument
write_LED:
pop r8                                  # getting the value from the stack into r8
movui   r9, 0x810                       # moving the address of the LEDS to r9
stw	    r8, (r9)                        # writing the value of r8 into the the address of the LEDS
ret                                     # returing back to the main function

endloop:
    br endloop
    .end