.data

.global _start
.text
_start:
    movui   r4, 0b0100                  # Setting which LEDS will be on by moving a value from 0 to 15 into r4    
    call    write_LED                   # calling the LED function

    br endloop


.global write_LED                       # function which will light an LED/S depending on the value of the given argument
write_LED:
movui   r9, 0x810                       # moving the address of the LEDS to r9
stw	    r4, (r9)                        # writing the value of r8 into the the address of the LEDS
ret                                     # returing back to the main function

endloop:
    br endloop
    .end