
@ read integers from a file and insert them into a linked-list to get sorted
@ and print the sorted list to the screen (stdout).

.text
main:

	@ open an input file to read integers
	ldr r0, =InFileName
	mov r1, #0
	swi 0x66		@ open file
	ldr r1, =InFileHandle
	str r0, [r1]


	@ you should read the first integer from the file (see below for how)
	@ and creat a root node for your tree
	@ and save the root node address to the label MyTree (which is declared in .data) for late references

    Loop:
	@ read integers from file
	ldr r1, =InFileHandle
	ldr r0, [r1]
	swi 0x6c	@ read an integer from a file (whose address is in r0)
	BCS CloseF	@ branch when the end of the file is reached
	
	@ print the integer just read above
	mov r1, r0     @ copy the integer to r1 ready to print
	mov r0, #1     @ Load 1 into register r0 (stdout handle) 
	SWI 0x6b       @ Print integer in register r1 to stdout

	@ print a space
	mov 	r0, 	#1
	ldr	r1, 	=Space
	swi	0x69    @ write string to stdout

	
	@ You should comment out the above code for printing
	@ Instead, you creat a tree node and save the integer into the node
	@ Put the root node address in r0, and the address of the to-be-inserted node in r1
	@ call the subroutine Insert to insert the newly created node into the tree
        @BL Insert     @ you should write subroutine Insert

	B Loop

     CloseF:
	@close infile
	ldr r0, =InFileHandle
	ldr r0, [r0]
	swi 0x68	@ close the file

	@ put the root node address in r0
	@BL PrintTree  @ you print the integers in non-descending order

exit:	SWI 0x11       @ Stop program execution 


Insert: @ your code for Insert goes here

PrintTree: @ your code for PrintTree goes here

		
.data
MyTree: .word 0
InFileName: .asciz "list.txt"
InFileHandle: .word 0
Space: .ascii " "