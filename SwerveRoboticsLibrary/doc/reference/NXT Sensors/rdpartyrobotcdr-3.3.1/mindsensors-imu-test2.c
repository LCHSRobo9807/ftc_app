#pragma config(Sensor, S1,     MSIMU,                sensorI2CCustomFastSkipStates)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

/*
 * $Id: mindsensors-imu-test2.c 133 2013-03-10 15:15:38Z xander $
 */

/**
 * mindsensors-imu.h provides an API for the Mindsensors AbsoluteIMU Sensor.  This program
 * demonstrates how to use that API.
 *
 * Changelog:
 * - 0.1: Initial release
 *
 * Credits:
 * - Big thanks to Mindsensors for providing me with the hardware necessary to write and test this.
 *
 * License: You may use this code as you wish, provided you give credit where it's due.
 *
 * THIS CODE WILL ONLY WORK WITH ROBOTC VERSION 3.59 AND HIGHER. 

 * Xander Soldaat (xander_at_botbench.com)
 * 26 August 2012
 * version 0.1
 */

#include "drivers/mindsensors-imu.h"

task main(){

  int heading;
  int x_val, y_val, z_val;      // axis values

  nxtDisplayCenteredTextLine(0, "Mindsensors");
  nxtDisplayCenteredBigTextLine(1, "IMU");
  nxtDisplayCenteredTextLine(3, "Test 2");
  nxtDisplayCenteredTextLine(5, "Connect sensor");
  nxtDisplayCenteredTextLine(6, "to S1");
  wait1Msec(2000);
  eraseDisplay();

  while (true){

		// Read the Compass
    heading = MSIMUreadHeading(MSIMU);

		nxtDisplayTextLine(1, "%d", heading);

		// Read the tilt
		MSIMUreadTiltAxes(MSIMU, x_val, y_val, z_val);

		nxtDisplayTextLine(5, "%d", x_val);
		nxtDisplayTextLine(6, "%d", y_val);
		nxtDisplayTextLine(7, "%d", z_val);
		wait1Msec(50);
  }
}

/*
 * $Id: mindsensors-imu-test2.c 133 2013-03-10 15:15:38Z xander $
 */