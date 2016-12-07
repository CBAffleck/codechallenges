#!/usr/bin/python

###		r/dailyprogrammer challenge		###

#Directions
print("To disarm the bomb you have to cut 4 wires. These wires are either white, black, purple, red, green or orange. The rules for disarming are simple: \n \
If you cut a white cable you can't cut white or black cable. \n \
If you cut a red cable you have to cut a green one \n \
If you cut a black cable it is not allowed to cut a white, green or orange one \n \
If you cut a orange cable you should cut a red or black one \n \
If you cut a green one you have to cut a orange or white one \n \
If you cut a purple cable you can't cut a purple, green, orange or white cable \n \
If you have anything wrong in the wrong order, the bomb will explode.")

#Get user input
i = 1
possible_wires = ["white", "black", "purple", "red", "green", "orange"]
wires = []
while (i < 5):
	x = input("Wire to cut: ")
	if x not in possible_wires:
		print("There's no wire with the color %s. Please choose again." %(x))
	else:
		wires.append(x)
		i+=1

#Check if bomb is defused or blows up
j = 0
while (j < 2):
	if wires[0] == "white" and wires[1] != "white" and wires[1] != "black":
		del wires[0]
		j+=1
	elif wires[0] == "red" and wires[1] == "green":
		del wires[0]
		j+=1
	elif wires[0] == "black" and wires[1] != "white" and wires[1] != "green" and wires[1] != "orange":
		del wires[0]
		j+=1
	elif wires[0] == "orange" and (wires[1] == "red" or wires[1] == "black"):
		del wires[0]
		j+=1
	elif wires[0] == "green" and (wires[1] == "orange" or wires[1] == "white"):
		del wires[0]
		j+=1
	elif wires[0] == "purple" and (wires[1] == "black" or wires[1] == "red"):
		del wires[0]
		j+=1
	else:
		break

if j == 2:
	print("Bomb defused")
else:
	print("Boom!")



