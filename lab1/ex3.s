#num1 = 5 -> sum = 6
#num1 = 50 -> sum = 600
#num1 = 100 -> sum = -1


.data

num1:		.word		100          # allocate memory for 32 -bit variable with user defined value
sum:		.word		0           # allocate memory for 32 -bit variable with value of 0, which will hold the sum of the numbers


.global _start
.text

_start:     
    movia		r2,	num1                # get the address coresponding to num1 and save it into r2
    ldw		    r2,	(r2)                # getting the value at the address of num1

    movia		r3,	sum                 # get the address coresponding to sum and save it into r3
    ldw		    r3,	(r3)                # getting the value at the address of sum

    movi		r4,	100                 # moving 100 into r4, it will be used for the if statement
    bge         r2, r4, else	        # jump to else if r2 >= r4(num1 >= 100)
    movi		r8,	0                   # set the i to 0, it will be used for summing, and the loop

loop:
    bge		    r8,	r2,	outOfLoop   # jump to outOfLoop if r8 >= r2 (i >= num1)
    add		    r3,	r3,	r8          # add r8 to r3(r3 = r3 + r8)
    addi		r8,	r8,	2           # add 2 to r8(r8 = r8 + 2)

    br loop


else:
    movi		r3,	-1                  # move -1 into r3 (r3 = -1)/(sum = -1)_
    
outOfLoop:
    movia		r2,	sum                 # get the address coresponding to sum and save it into r2
    stw		    r3,	(r2)                    # store the content of r3(sum) into the address of the sum variable
    
    

endloop:
    br endloop
    .end
