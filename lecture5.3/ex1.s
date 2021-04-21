# Please translate following C language program to assembly language: 
# int i; // i is stored in register r2 
# int sum = 0; // sum is stored in main memory at 
#		// address a_sum 
# for(i=0; i<10; i++) sum = sum + i;

	.data
	
a_sum:	.byte 0			# create and reserve memory for a variable a_sum with starting value 0
	
	.global	_start
	.text
	
_start:
	
	
	movi r2, 0		# store 0 -> r2(it will be used as iterator like the variable 'i')
	movi r4, 10		# store 10 -> r4(it will be used as stop conditon for the loop i < 10)
	movia r5, a_sum		# store the address where a_sum is located into r5(it will be used to get the value out of that address and also store it after all the operations)
	ldbu r3, (r5)		# store a_sum's value into r3
loop:	
	bgeu r2, r4, outOfLoop	# check if r2 => r4( i >= 10), and if so get out of the loop
	add r3, r3, r2		# sum r3,r2 and store it in r3 ( r3 = r3 + r2/ sum = sum + i)
	addi r2, r2, 1		# add 1 to r2 (i++)
	br loop			# jump to loop
	
outOfLoop:
	stb r3, (r5)		# r3 will hold the sum, and we store it at the address of a_sum
	
	
endloop:
	br endloop
	.end