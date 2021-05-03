# The following high-level language program is given: 
# short tri_l1 = 42; 
# short tri_l2 = 27; 
# int tri_area = 0; 
# tri_area = ???; 
# The program calculates the area of a rectangular triangle, 
# where tri_l1 and tri_l2 are the lengths of the two legs of the triangle forming the right angle. 
# Supplement the given high-level language with the commands necessary for area calculation 
# and translate the program into a corresponding assembly language program. 
# Assume that the data type short is a signed 16-bit integer 
# and the data type int is a signed 32-bit integer. 
# The variable tri_l1 is to be stored in main memory at address a_tri_l1, 
# the variable tri_l2 at address a_tri_l2 and tri_area at address a_tri_area. 
# What is the result of the area calculation?  
# RESULT: 567
  
    .data

tri_l1:		.hword	42		# allocate memory for 16-bit variable with value 42
tri_l2:		.hword	27		# allocate memory for 16-bit variable with value 27
tri_area:	.word	0		# allocate memory for 32-bit variable with value 0


    .global _start
    .text

_start:

    movia	r2,	tri_l1		# get the address coresponding to tri_l1 and save it into r2
    movia	r3,	tri_l2		# get the address coresponding to tri_l2 and save it into r3
    movia	r4,	tri_area	# get the address coresponding to tri_area and save it into r4
    ldh	    r2,	(r2)		# get the value in the address tri_l1 and save it into r2
    ldh	    r3,	(r3)		# get the address coresponding to tri_l2 and save it into r3
    mul	    r2,	r2,	r3	    # multiply r2 and r3 and save it into r2 (r2 = r2 * r3), multiply one of the sides of the triangle with the other one (tri_l1 * tri_l2)
    movi	r3,	2		    # move 2 into r3 because we will need it for the area formula
    div     r2,	r2,	r3	    # divide (r2 * r3) by 2 and save it into r2 (r2 = (r2 * r3) / 2), (tri_l1 * tri_l2) / 2
    sth		r2,	(r4)		# store the value of r2 into tri_area
    

endloop:
    br endloop
    .end
