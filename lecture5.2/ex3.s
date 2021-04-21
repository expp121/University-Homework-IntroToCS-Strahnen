# Write a program which sets bit 5 of any letter belonging to ASCII-coded string 
# stored in main memory starting at address 'letter1'
#0x03,ETX - end of text = 00000011
	.data 

letter1:	.ascii "O" 
		.ascii "K"
		.ascii "U"
		.ascii "S"
		.ascii "X"
		.ascii "O"
		.ascii "Y"
		.ascii "y"
		.ascii "e"
		.ascii "a"
		.ascii "h"
			
ETX:	.byte 0
	.word 0

	.global _start 
	.text 
	
_start: 
	movia r2, letter1		# load into r2, the memory address of the letter
	subi sp, sp, 4			# increment the stack pointer
	stw r2, (sp)			# save the memory address of the letter into the stack
	call findLenghtAndChangeBit	# call the findLenghtAndChangeBit procedure(function)
	br endloop			#FINISH
	

findLenghtAndChangeBit:
	movi r5, 0		# will hold the string lenght
	ldw r2, (sp)		# load from the stack into r2, the address of the first letter
	addi sp, sp, 4		# change the stack pointer back to normal
	ldbu r3, (r2)		# load into r3, the value at the address of the first letter(r2)
	beq r3, r1, stringEnd	# check if the letter is null, and if so go to 'stringEnd'

nextLetter:
	addi r5, r5, 1		# increment the string lenght
	ori r3, r3, 0x20	# set the fifth bit from the letter to '1' ('o'r r3 with mask 00010000)
	
	stb r3, (r2)		# write the new letter's value to it's corresponding memory address(save the new value to memory)
	addi r2, r2, 1		# increment r2, to point to the next letter
	ldbu r3, (r2)		# load into r3, the value at the address of the next letter(r2)
	beq r3, r1, stringEnd	# check if the letter is null, and if so go to 'stringEnd'
	
	br nextLetter		# go to nextLetter
	
	
stringEnd:
	ret			# return to the main function

endloop: 

	br endloop 
	.end 	
