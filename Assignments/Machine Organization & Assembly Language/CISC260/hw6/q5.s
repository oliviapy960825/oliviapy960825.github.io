main:
	ldr r2, =myarray
	mov r3, #0
	mov r4, #4
LOOP: cmp r3, r4
	bgt Stop
	
	ldr r0, [r2, r3, LSL #2]

	ldr r1, =changePos 		; load position of modifiable code
	cmp r0, #10				; compare N and 10
	ldrgt r5, =0xe0810000;  ; if N > 10, load code of add instruction 
	ldrle r5, =0xe0000091;  ; if N <= 10, load code of mul instruction 
	str r5, [r1] 			; place code of instruction

factCall:
	bl fact
	mov r1, r0
	MOV r0, #1 ; Load 1 into register r0 (stdout handle)
	SWI 0x6b ; Print integer in register r1 to stdout
		
	; print a space
	mov r0, #1
	ldr r1, =Space
	swi 0x69 ; write string to stdout

	add r3, r3, #1
	b LOOP
Stop: SWI 0x11 ; Stop program execution

fact: sub sp, sp, #8
	str lr, [sp,#0]
	str r0, [sp,#4]
	cmp r0,#1
	bgt L1
	mov r0, #1
	add sp, sp, #8
	mov pc, lr
L1: sub r0, r0, #1
	BL fact
	mov r1, r0
	ldr r0, [sp, #4]
	ldr lr, [sp, #0]
	add sp, sp, #8
changePos: mul r0, r1, r0
	mov pc, lr
.data
	myarray: .word 2, 3, 14, 5, 6
	Space: .ascii " "