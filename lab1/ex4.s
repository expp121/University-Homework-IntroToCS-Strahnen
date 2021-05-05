	.data

A:  .word       1
    .word       2
    .word       3
    .word       4
    .word       5
    .word       6
    .word       7
    .word       8
    .word	0xFFFFFFFF      		# marks the end of the array
    
B:  .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word       0
    .word	0xFFFFFFFF       		# marks the end of the array

.macro push rX                   		# creating a macro which wraps the two instructions for pushing into the stack
    subi	    	sp,	sp,	4
    stw		    	\rX,    (sp)
.endm

.macro pop rX                    		# creating a macro which wraps the two instructions for poping from the stack
    ldw		    	\rX,	(sp)
    addi		sp,	sp,	4 
.endm    


	.global _start
	.text

_start:
    movia	r2,	A       	# get the address coresponding to A and save it into r2
    call 	findArrayLength        	# call the subroutine to find the length of array
    pop         r2              	# get the return value from the findArrayLength subroutine and save into r2

    movi	r8,	0       	# initializing r8 as the variable i
    movi	r9,	42	      	# initializing r9 as the variable c

    movia	r3,	A       	# save the starting memory address of array 'a[]' into r3
    movia	r4,	B       	# save the starting memory address of array 'b[]' into r4
    
    
loop:
    bge		r8,	r2,	endloop # jump to endloop if r8 >= r2 (i >= array.length())
    ldw		r5,	(r3)            # load the value which is at the address of r3 into r5
    add	        r5,	r5,	r9      # adds an element from the array with 42(a[i] = a[i] + 42)
    stw		r5,	(r4)            # saving the new value into the other array(b[i] = a[i])
    addi	r3,	r3,	4       # getting the next element from array a[]
    addi	r4,	r4,	4       # getting the next element from array b[]
    addi	r8,	r8,	1       # incrementing i by 1(i++)
    br          loop

findArrayLength:
    movi	r3,	0               # r3 will hold the length of the array
    movi	r5,	0xFFFF          # r5 will hold the value which corresponds to end of array
    

    loopFindLength:
    ldw		r4,	(r2)            # load n-th element from array into r4 for later comparison
    beq		r4,	r5,	finish  # compares the n-th element with the value assigned for array end, and if they are equal, jumps to finish
    addi	r3,	r3,	1       # increments the variable holding the length of the array by 1
    addi	r2,	r2,	4       # getting the next element from array
    br		loopFindLength
    
    finish:
    push        r3                      # saving the array length on the stack
    ret


endloop:
    br endloop
    .end
