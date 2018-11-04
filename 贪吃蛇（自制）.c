#include<stdio.h>
#include<windows.h>
#include<time.h>
#include<conio.h>
#define width 20
#define height 40
struct thing
{
    int x;
    int y;
}food,ducao,dilei;
struct snake
{
    int a[100][2];
    int length;
    int speed;
}snake;
void map();
void eat();
void move();
void gotoxy(int x,int y);
int snakeailve();
void speed();
char fx='w';
int i,j,l;
int grade=0;
int addition=0;
int main()
{
  map();
  while(1)
  {
      eat();
      speed();
      move();
      Sleep(snake.speed);
      if(!(snakeailve()))
        break;
  }
  printf("Game over!");
  getch();
  return 0;
}
void map()
{
  srand(time(NULL));
  food.x=rand()%36+2;
  food.y=rand()%16+2;
  gotoxy(food.x,food.y);
  printf("$");
  ducao.x=rand()%36+2;
  ducao.y=rand()%16+2;
  gotoxy(ducao.x,ducao.y);
  printf("!");
  dilei.x=rand()%36+2;
  dilei.y=rand()%16+2;
  gotoxy(dilei.x,dilei.y);
  printf("#");
  snake.a[0][0]=height/2;
  snake.a[0][1]=width/2;
  gotoxy(snake.a[0][0],snake.a[0][1]);
  printf("O");
  snake.length=3;
  snake.speed=200;
  for(l=1;l<snake.length;l++)
  {
      snake.a[l][0]=snake.a[l-1][0];
      snake.a[l][1]=snake.a[l-1][1]+1;
      gotoxy(snake.a[i][0],snake.a[i][1]);
      printf("O");
  }
  for(i=0;i<width;i++)
  {
      gotoxy(0,i);
      printf("■");
      gotoxy(height,i);
      printf("■");
  }
  for(j=0;j<height-1;j=j+2)
  {
      gotoxy(j,0);
      printf("■");
      gotoxy(j,width-1);
      printf("■");
  }
  gotoxy(height+2,width-1);
  printf("你的分数为%d ($是食物,!是毒草,#是地雷)",grade);
}
void move()
{
   if(kbhit())
       fx=getch();
    if(addition==0)
    {
        gotoxy(snake.a[snake.length-1][0],snake.a[snake.length-1][1]);
        printf(" ");
    }
    else if(addition==-1)
    {
        gotoxy(snake.a[snake.length-1][0],snake.a[snake.length-1][1]);
        printf(" ");
        gotoxy(snake.a[0][0],snake.a[0][1]);
        printf(" ");
    }
    for(l=snake.length-1;l>0;l--)
    {
        snake.a[l][0]=snake.a[l-1][0];
        snake.a[l][1]=snake.a[l-1][1];
    }
    switch(fx)
    {
      case 'w':snake.a[0][1]--;break;
      case 's':snake.a[0][1]++;break;
      case 'a':snake.a[0][0]--;break;
      case 'd':snake.a[0][0]++;break;
      default:break;
    }
    gotoxy(snake.a[0][0],snake.a[0][1]);
    printf("O");
    addition=0;
    gotoxy(height+2,0);
}
int snakeailve()
{
    if(snake.a[0][0]==0||snake.a[0][0]==height-1||snake.a[0][1]==0||snake.a[0][1]==width-1)
        return 0;
    if(snake.length<2)
        return 0;
    for(i=1;i<snake.length;i++)
    {
        if(snake.a[i][0]==snake.a[0][0]&&snake.a[i][1]==snake.a[0][1])
            return 0;
    }
    return 1;
}
void eat()
{
 if(snake.a[0][0]==food.x&&snake.a[0][1]==food.y)
    {
        srand(time(NULL));
        food.x=rand()%36+2;
        food.y=rand()%16+2;
        while(1)
        {
          for(i=0;i<snake.length;i++)
          {
              if(snake.a[i][0]==food.x&&snake.a[i][1]==food.y)
              {
                food.x=rand()%36+2;
                food.y=rand()%16+2;
                l=1;
                break;
              }
              else l=0;
          }
              if(l==0)
                break;
        }
        gotoxy(food.x,food.y);
        printf("$");
        grade++;
        if(grade>=0)
        {
            gotoxy(height+2,width-1);
            printf("你的分数为%d ",grade);
        }
        else
        {
            gotoxy(height+2,width-1);
            printf("你的分数为%d",grade);
        }
        snake.length++;
        addition=1;
   }
 if(snake.a[0][0]==ducao.x&&snake.a[0][1]==ducao.y)
    {
        srand(time(NULL));
        ducao.x=rand()%36+2;
        ducao.y=rand()%16+2;
        while(1)
        {
          for(i=0;i<snake.length;i++)
          {
              if(snake.a[i][0]==ducao.x&&snake.a[i][1]==ducao.y)
              {
                ducao.x=rand()%36+2;
                ducao.y=rand()%16+2;
                l=1;
                break;
              }
              else l=0;
          }
              if(l==0)
                break;
        }
        gotoxy(ducao.x,ducao.y);
        printf("!");
        gotoxy(snake.a[snake.length-1][0],snake.a[snake.length-1][1]);
        printf(" ");
        grade--;
        gotoxy(height+2,width-1);
        printf("你的分数为%d",grade);
        snake.length--;
        addition=-1;
   }
 if(snake.a[0][0]==dilei.x&&snake.a[0][1]==dilei.y)
    snake.length=1;
}
void speed()
{
    if(snake.length<6)
        snake.speed=200;
    else if(snake.length<10)
        snake.speed=100;
    else if(snake.speed<20)
        snake.speed=50;
    else if(snake.speed<30)
        snake.speed=25;
}
void gotoxy(int x,int y)
{
    COORD p;
    HANDLE h;
    p.X=x;
    p.Y=y;
    h=GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleCursorPosition(h,p);
}
