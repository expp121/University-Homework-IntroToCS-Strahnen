	CLO
	JMP START
	DB 7E
	DB 3
	
START:
	MOV AL , [03]
	MOV BL , [04]
	CALL 30
	ADD AL, 30
	MOV [C0], AL


MODULO:
	ORG 30
	MOD AL, BL
	RET

	END


	