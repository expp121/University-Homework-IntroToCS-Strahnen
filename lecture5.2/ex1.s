# Write a program which adds following 3 numbers: -600, 4000 and 2000

	.data

A:	.hword	-600
B:	.hword	2000
C:	.hword	4000

	.global _start
	.text
	
_start:
	movia r2, B		# loads the memory address of variable B into R2
	ldhu r2, (r2)	# gets the value stored at the memory address of B (Get unsigned 16 bit value)

	
	movia r3, C		# loads the memory address of variable C into R3
	ldhu r3, (r3)	# gets the value stored at the memory address of C (Get unsigned 16 bit value)
	
	add r2,r2,r3	# adds r2 and r3 and saves it in r2 -> r2 = r2 + r3 ( r2 = B + C)
	
	movia r3, A		# loads the memory address of variable A into R3
	ldh r3, (r3)	# gets the value stored at the memory address of A (Get signed 16 bit value)
	
	add r2, r2, r3	# adds r2 and r3, and saves it in r2 -> r2 = r2 + r3 (r2 = (B + C) + (-A))
	
	

endloop:
	br endloop
	.end
