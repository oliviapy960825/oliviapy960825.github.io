.text
	B	main				; jump to the programs entry point 
	
functTail:
	SUB	sp, sp, #4			; allocate place on the stack for return address
	STR	lr, [sp, #0]		; store return address

	CMP	r0, #0				; compare x to 0
	BGT	functTailRec		; if n > 0, go to recursive call

	MOV r0, r1				; else, return a
	B 	functTailEnd		; 

functTailRec:
	STR r0, [sp, #0]		; store original argument into stack

	TST r0, #1				; check if the x is even

	BEQ	functTailEven		; if the x is even, jump forward

	ADD r1, r1, r0			; a = a + x
	SUB r0, r0, #1			; x = x - 1

	BL functTail			; do the recursive call
	B functTailEnd			; return

functTailEven:				; if the x is even
	ADD r1, r1, #3			; a = a + 3
	SUB r1, r1, r0			; a = a + 3 - x
	SUB r0, r0, #3			; x = x - 3

	BL functTail			; do the recursive call
							
							; return
functTailEnd:
	LDR	lr, [sp, #0]		; restore return address
	ADD sp, sp, #4			; pop items off the stack
	MOV	pc, lr				; return to the caller

; test code
main:
	MOV	r0, #9				; call functTail(9, 0), should be 9
	MOV	r1, #0				;
	BL	functTail			; 

	swi 0x11				; stop emulation

.end
