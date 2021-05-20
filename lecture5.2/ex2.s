# Write a program which adds the two 32-bit numbers 
# stored at addresses 'num1' and 'num2' and which stores the result at address 'result'
	.data
	
num1:	.word 0x12345678	# saving in memory variable num1 which equals to 0x12345678(hex)
num2:	.word 0x20000000	# saving in memory variable num2 which equals to 0x20000000(hex) 
result:	.word 0x00000000	# saving in memory variable result which equals to 0
	
	.global _start 
	.text 

_start: 
	movia r2, num1		# saving the address in main memory of num1 into r2
	ldw r2, (r2)		# getting the value at the address of num1 into r2
	
	movia r3, num2		# saving the address in main memory of num1 into r3
	ldw r3, (r3)		# getting the value at the address of num2 into r3
	
	add r2, r2 ,r3		# adding r2,r3 and saving it in r2(r2 = r2 + r3/ r2 = num1 + num2)
	movia r3, result	# saving the address in main memory of result into r3
	stw r2, (r3)		# storing the value of r2 into the memory address contained in r3 (result = r2)
	
endloop: 
	br endloop 
	.end