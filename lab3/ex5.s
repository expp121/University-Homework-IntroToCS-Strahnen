# .data

# Str: .skip 64
# .global _start
# .text

# _start:

#     movia r4, Str
#     call receiveString0
# br endloop

# receiveString0:
#     movi r16, 0x860         # RxData byte
#     movi r17, 0x868         # RxReady byte
#     movi r2, 0              # will store string lenght
#     movi r10, 10            # r10 will hold the end of line character (LF)
#     floop:
#         ldbu r9, (r17)          # loads the byte containing RxReady into r9
#         srli r9, r9, 7          # shifts 7 bits to the right to extract RxReady
#         beq r9, r0, endf        # jumps to endf if RxReady is 0
#         ldbu r9, (r16)
#         beq r9, r10, lfChar
#         stb r9, (r4)
#         addi r2, r2, 1
#         addi r4, r4, 1
        
#     br floop

#     lfChar:
#         stb r0, (r4)
#     endf:
# ret


# endloop:
#     br endloop
#     .end


# # RxData address: 0x860
# # RxReady address: 0x868 (when there is data in rxData, rxReady will be 1) 


.data
Str: .skip 64                   # allocate 64 bytes of memory
.equ UART0RX, 0x860

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
    movia r4, Str               # move the address of where Str is stored into r4
    call receiveString0         # call the function
br endloop


receiveString0:
    push r31                    # save the return address onto the stack, because we are calling nested subroutine
    mov r8, r4                  # moving r4 into r8, because r4 will be used as argument for the nr_uart_rxchar function
    movi r9, 0                  # will store string lenght
    movi r10, 10                # r10 will hold the end of line character (LF)
    movia r4, UART0RX           # moving the uart RxData into r4
    loop:
        call nr_uart_rxchar     # calling the built-in function which reads a byte from the uart and returns it in r2
        beq r2, r0, endf        # checking if the result from the function is null, and jumping if so(we either don't have input or we are pass the LF character)
        beq r2, r10, LFchar     # checking if the result from the function is LF , and jumping 
        stb r2, (r8)            # storing the result from the function into the address of the Srt variable
        addi r8, r8 ,1          # incrementing the pointer, to point to the next byte for the next character to be stored
        addi r9, r9 ,1          # incrementing the length of the string
    br loop

LFchar:
    stb r0, (r8)                # writing null at the end of the string

endf:
    pop r31                     # restoring the return address 
    mov r2, r9                  # moving the length of the string, from r9 to r2 (ABI)

ret

endloop:
    br endloop
    .end