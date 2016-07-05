#include "mbed.h"
/*
 * This program will run the prototype mapping robot wheels motors to
 test some basic maneuvers 
 * 
 * 
 * 
 * The wheels use a digital inputs to control them with a pwm
 * input to control speed.
 * There are sensors on the wheels to track rotations which will
 * will give digital inputs.
 * 
 */
 
 
/* assorted globals */

/* Wheel 1*/
DigitalOut w1_in1(D4);
DigitalOut w1_in2(D5);
PwmOut w1_pwm(D6);
DigitalOut w1_stby(D7);
InterruptIn w1_cha(D12);
InterruptIn w1_chb(D13);


/* Wheel 2*/
DigitalOut w2_in1(D8);
DigitalOut w2_in2(D9);
PwmOut w2_pwm(D10);
DigitalOut w2_stby(D11);
InterruptIn w2_cha(D14);
InterruptIn w2_chb(D15);

/* Sensors*/
DigitalIn s1(A0);
DigitalIn s2(A1);
DigitalIn s3(A2);
//DigitalIn s4(A3);

DigitalOut myled(LED3);

/* tracks direction 0 is backwards and 1 is forwards*/
int dir;

/*counts a comparions for wheel 1 sensors*/
int w1_count_a;
int w1_count_b;
int w1_dif_a;
int w1_dif_b;

/*counts a comparions for wheel 2 sensors*/
int w2_count_a;
int w2_count_b;
int w2_dif_a;
int w2_dif_b;

/*proximity sensors*/
int s1_check;//front left
int s2_check;//front right
int s3_check;//back left
//int s4_check;//back right currently missing.


/*inturrupts fof wheel sensors*/
void count_w1_a()
{
w1_count_a++;    
}

void count_w1_b()
{
w1_count_b++;    
}

void count_w2_a()
{
w2_count_a++;    
}

void count_w2_b()
{
w2_count_b++;    
}

/*resets counters for different movments*/
void reset(){
 
 w1_count_a = 0;
 w1_count_b = 0;
 w2_count_a = 0;
 w2_count_b = 0;
 printf("Reset%\n\r"); 
    
}

/*stops with breaks*/
void stop(){
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 1;
    w1_in2 = 1;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 1;
    w2_in2 = 1;
    printf("Stop%\n\r"); 
}

/*goes backwards a small distance*/
void backward(){
 reset();
 
 while(w1_count_a < 30 && w1_count_b < 29 && w2_count_a < 30 && w2_count_b < 29){
     w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 0;
    w1_in2 = 1;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 1;
    w2_in2 = 0;  
     }
 stop();
 
 printf("backward%\n\r"); 
 
    
} 
    
/*goes forewards a small distance*/    
void forward(){
 
 reset();
 
 while(w1_count_a < 30 && w1_count_b < 29 && w2_count_a < 30 && w2_count_b <29){
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 1;
    w1_in2 = 0;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 0;
    w2_in2 = 1;
     }
 stop();
 
 printf("forward%\n\r"); 
 
    
}     

/*turns right 90 degrees*/  

void turnr(){
 reset();
 
 while(w1_count_a < 14 && w1_count_b < 13 && w2_count_a < 14 && w2_count_b < 13){
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 1;
    w1_in2 = 0;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 1;
    w2_in2 = 0;
     }
 stop();
 
 printf("turned right%\n\r"); 
 
    
}

/*turns left 90 degrees*/  
void turnl(){
 reset();
 
 while(w1_count_a < 14 && w1_count_b < 13 && w2_count_a < 14 && w2_count_b < 13){
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 0;
    w1_in2 = 1;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 0;
    w2_in2 = 1;
     }
 stop();
 
 printf("turned left%\n\r"); 
 
    
}

/*Uses a series of movemnts to make a square*/  
void square(){
    
    forward();
    turnr();
    forward();
    turnr();
    forward();
    turnr();
    forward();
    turnr();
    
    }
    
/*sets the robot to go continuously forward*/    
void c_forward()
{
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 1;
    w1_in2 = 0;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 0;
    w2_in2 = 1;  
    
    dir = 1;
}

/*sets the robot to go continuously backward*/   
void c_backward()
{
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 0;
    w1_in2 = 1;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 1;
    w2_in2 = 0;  
}

/*sets the robot to go continuously spin left*/   
void c_left()
{
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 1;
    w1_in2 = 0;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 1;
    w2_in2 = 0;
}

/*sets the robot to go continuously spin right*/   
void c_right()
{
    w1_pwm = 0.5;
    w1_stby= 1;
    w1_in1 = 0;
    w1_in2 = 1;
    
    w2_pwm = 0.5;
    w2_stby= 1;
    w2_in1 = 0;
    w2_in2 = 1;
}



int main() {
     
     
     printf("Online%\n\r");
     
     wait_ms(500);
     
     w1_cha.fall(&count_w1_a);
     w1_chb.fall(&count_w1_b);
     
     w2_cha.fall(&count_w2_a);
     w2_chb.fall(&count_w2_b);
     
     /* test maneuvers */
     forward();
     backward();
     
     turnr();  
     turnl();
     turnl();
     
     square();
     
    while(1) {

         if (w1_count_a != w1_dif_a){
        
         w1_dif_a = w1_count_a;
        printf("w1 count a = %d\n\r", w1_dif_a);
        }

        if (w1_count_b != w1_dif_b){
         w1_dif_b = w1_count_b;
        printf("w1 count b = %d\n\r", w1_dif_b);
        }
        
        if (w2_count_a != w2_dif_a){
        
         w2_dif_a = w2_count_a;
        printf("w2 count a = %d\n\r", w2_dif_a);
        }

        if (w2_count_b != w2_dif_b){
         w2_dif_b = w2_count_b;
        printf("w2 count b = %d\n\r", w2_dif_b);
        }
        myled = !myled;
    }
}