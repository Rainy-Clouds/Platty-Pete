import pygame
import io

pygame.init()

pygame.font.init()

level = [["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"], \
["n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n"]]

window = pygame.display.set_mode((800, 600))

pygame.display.set_caption("Level Editor")

gameLoop = True
while gameLoop:
	window.fill((77, 244, 255))

	keys = pygame.key.get_pressed()
	if keys[pygame.K_g]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "g"
	if keys[pygame.K_d]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "d"
	if keys[pygame.K_l]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "l"
	if keys[pygame.K_o]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "o"
	if keys[pygame.K_n]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "n"
	if keys[pygame.K_b]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "b"
	if keys[pygame.K_t]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "t"
	if keys[pygame.K_1]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "1"
	if keys[pygame.K_2]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "2"
	if keys[pygame.K_w]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "w"
	if keys[pygame.K_u]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "u"
	if keys[pygame.K_q]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "q"
	if keys[pygame.K_k]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "k"
	if keys[pygame.K_f]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "f"
	if keys[pygame.K_v]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "v"
	if keys[pygame.K_r]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "r"
	if keys[pygame.K_COMMA] and (keys[pygame.K_LSHIFT] or keys[pygame.K_RSHIFT]):
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "<"
	if keys[pygame.K_PERIOD] and (keys[pygame.K_LSHIFT] or keys[pygame.K_RSHIFT]):
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = ">"
	if keys[pygame.K_LEFTBRACKET]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "["
	if keys[pygame.K_RIGHTBRACKET]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "]"
	if keys[pygame.K_s]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "s"
	if keys[pygame.K_i]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "i"
	if keys[pygame.K_x]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "x"
	if keys[pygame.K_c]:
		mousex, mousey = pygame.mouse.get_pos()
		gridmousex = (mousex - (mousex % 40)) // 40
		gridmousey = (mousey - (mousey % 40)) // 40
		level[gridmousey][gridmousex] = "c"

	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			gameLoop = False
		elif event.type == pygame.KEYUP:
			if keys[pygame.K_p] and keys[pygame.K_LCTRL]:
				with open('Levels\\LevelFour.txt', 'r') as file:
					leveldata = file.readlines()
				i = 0
				for x in range(15):
					newData = ""
					for char in level[i]:
						newData = newData + char
					i += 1
					#print(newData)
					if(x != 14):
						leveldata[x] = leveldata[x][0 : len(leveldata[x]) - 1] + newData + '\n'
					else:
						leveldata[x] = leveldata[x][0 : len(leveldata[x])] + newData
				with open('Levels\\LevelFour.txt', 'w') as file:
					file.writelines(leveldata)
					print("Level edited sucessfully")
			elif keys[pygame.K_x] and keys[pygame.K_LCTRL]:
				for y in range(15):
					for x in range(20):
						level[y][x] = "n"

	for y in range(0, 15):
		for x in range(0, 20):
			if level[y][x] == "g":
				pygame.draw.rect(window, (0, 255, 0), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "d":
				pygame.draw.rect(window, (209, 115, 0), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "l":
				pygame.draw.rect(window, (255, 132, 0), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "o":
				pygame.draw.rect(window, (255, 100, 0), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "b":
				pygame.draw.rect(window, (230, 167, 60), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "t":
				pygame.draw.rect(window, (163, 107, 47), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "1":
				pygame.draw.rect(window, (255, 71, 224), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "2":
				pygame.draw.rect(window, (71, 218, 255), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "w":
				pygame.draw.rect(window, (0, 0, 255), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "u":
				pygame.draw.rect(window, (0, 80, 255), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "q":
				pygame.draw.rect(window, (255, 255, 0), (x * 40, y * 40, 40, 10))
			elif level[y][x] == "k":
				pygame.draw.rect(window, (220, 220, 220), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "f":
				pygame.draw.rect(window, (255, 50, 50), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "v":
				pygame.draw.rect(window, (50, 50, 255), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "r":
				pygame.draw.rect(window, (208, 54, 255), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "<":
				pygame.draw.rect(window, (184, 213, 217), (x * 40, y * 40, 40, 40))
			elif level[y][x] == ">":
				pygame.draw.rect(window, (217, 194, 184), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "[":
				pygame.draw.rect(window, (0, 0, 100), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "]":
				pygame.draw.rect(window, (100, 0, 0), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "s":
				pygame.draw.rect(window, (255, 255, 0), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "i":
				pygame.draw.rect(window, (255, 255, 255), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "x":
				pygame.draw.rect(window, (145, 145, 145), (x * 40, y * 40, 40, 40))
			elif level[y][x] == "c":
				pygame.draw.rect(window, (125, 125, 125), (x * 40, y * 40, 40, 40))


	pygame.display.flip()

pygame.quit()