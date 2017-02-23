import turtle
import math

def draw_square(sqName):
    i = 0
    while (i < 4):
        sqName.forward(100)
        sqName.right(90)
        i+=1



def draw_shapes():
    window = turtle.Screen()
    window.bgcolor("red")
    
    tom = turtle.Turtle()

    
    tom.shape("circle")
    tom.color("green")
    tom.speed(6)
    
    for i in range(1,25):
        draw_square(tom)
        tom.right(15)
    
        
    # teresa = turtle.Turtle()
#     teresa.shape("arrow")
#     teresa.color("blue")
#
#     teresa.circle(100)
#
#
#
#
#     tim= turtle.Turtle()
#     tim.shape("turtle")
#     tim.color("orange")
#
#
#     x=math.sqrt(100**2 + 100**2)
#     # tim.right(-45)
#     tim.backward(100)
#     tim.right(-45)
#     tim.forward(x)
#     tim.right(-45)
#     tim.backward(100)


    window.exitonclick()


draw_shapes()    
    