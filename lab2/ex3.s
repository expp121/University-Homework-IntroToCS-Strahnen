.data

.global _start
.text

_start:
    call read_KEY0          # calling read_KEY0 function
    call read_KEY3          # calling read_KEY3 function
br endloop

read_KEY0:                  # a function which reads the state of the most left button
movui r2, 0x840             # stores the address of all the buttons into r2
ldb	r2,	(r2)                # get the value stored in r2 back to r2
andi    r2,	r2,	1           # ands the value of r2 because the function should return either 1 or 0(discards all the bits except the first one)
ret                         # returns to the main function

read_KEY3:                  # a function which reads the state of the most right button
movui r2, 0x840             # stores the address of all the buttons into r2
ldb	r2,	(r2)                # get the value stored in r2 back to r2
srli    r2,	r2,	3           # shifts r2 by 3 bits to the right, so we get only the 4th bit which corresponds to the most right button
ret

endloop:
    br endloop
    .end