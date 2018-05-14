/*__MenyBuganim_302490610___BaruchRothkoff_311603252*/

public class carWashMachine implements Runnable {
int washMachine;		//מספר מתקני שטיפה
double avgInCar;		//זמן ממוצע להגעה של רכב
double avgWashCar;		//זמן ממוצע לשטיפת רכב
double runTime;			//זמן ריצה של ההדמיה
double time;
semaphore sema;	


public carWashMachine(int washMachine,double avgInCar,double avgWashCar,double runTime,double time){
	washMachine=this.washMachine;
	avgInCar=this.avgWashCar;
	avgWashCar=this.avgWashCar;
	runTime=this.runTime;
	time=this.time;
	sema=new semaphore(washMachine);
}

public synchronized void add(long time){
	washMachine++;
	time+=(System.currentTimeMillis());
}

public void run(){
	
}
}
