.data

A:  .word       1
    .word       2
    .word       3
    .word       4
    .word       5
    .word       6
    .word       7
    .word       8

B:  .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word       0

    

.global _start
.text

_start:

    movi		r2,		8       # loop control variable
    movi		r8,		0       # i
    movi		r9,		42      # c
    movi		r10,    4

    movia		r3,		A       # save the starting memory address of array 'a[]' into r3
    movia		r4,		B      # save the starting memory address of array 'b[]' into r4
    
    
loop:
    bge		r8,		r2,		endloop
    ldw		r5,		(r3)
    add	    r6,		r5,		r9
    stw		r6,		(r4)

    add		r3,		r3,		r10
    add		r4,		r4,		r10
    addi	r8,		r8,		1
    br loop


endloop:
    br endloop
    .end
