.text
	B	main				; jump to the programs entry point

fib:
	SUB	sp, sp, #12			; allocate place on the stack for 3 items: return address, n, result of fib(n-1)
	STR	lr, [sp, #8]		; store return address
	STR r0, [sp, #4]		; store parameter

	CMP	r0, #1				; compare n to 1
	BGT	fibrec				; if n > 1, go to recursive call

	LDR	lr, [sp, #8]		; restore return address
	ADD sp, sp, #12			; pop items off the stack
	MOV	pc, lr				; return to the caller

fibrec:
	SUB r0, r0, #1			; calculate n - 1
	BL	fib					; calculate fib(n - 1)
	STR	r0, [sp, #0]		; store fib(n - 1) to allocated space

	LDR	r0, [sp, #4]		; reload n
	SUB r0, r0, #2			; calculate n - 2
	BL	fib					; calculate fib(n - 2)

	LDR r1, [sp, #0]		; reload fib(n - 1)
	ADD r0, r0, r1			; return fib(n - 2) + fib(n - 1)



main:
	MOV	r0, #10				; test with n = 10, should be 55
	BL	fib					; call fib(n)

	swi 0x11				; stop emulation

.end
