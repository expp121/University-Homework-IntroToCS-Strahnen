.data

.global _start
.text

_start:

movui r4, 65        # moving the value which will be sent to UART0 into r4
call sendChar0      # calling the function which sends a character to the UART0

br endloop

sendChar0:
    movui r8, 0x864     # Storing the address of TxData into r8
    movui r9, 0x868     # Storing the address of TxReady into r9
    
    stb r4,(r8)         # sending the character in r4 to TxData(0x864)

waitForTransmission:
    ldbu r10, (r9)      # loading the value of the byte which contains RxReady and TxReady into r10
    srli r10, r10, 6    # getting rid of the first six least significant bits, because they are not used(shifing 6 bits)
    andi r10, r10, 1    # AND-ing to extract only TxReady bit, because RxReady is right next to it
    bne r10, r0, sent   # jump to end of function if TxReady is 1 (that means the byte was sent)
br waitForTransmission

sent:
ret

endloop:
    br endloop
    .end