
public class InstrumentTest {
    public static void main(String[] args) {

        // Testing Musical Instruments
        Guitar guitar = new Guitar();
        guitar.use();
        guitar.tuneStrings();
        guitar.play();
        guitar.pluck();

        Violin violin = new Violin();
        violin.use();
        violin.tuneStrings();
        violin.play();
        violin.bow();

        Flute flute = new Flute();
        flute.use();
        flute.adjustingHeadJoint();
        flute.blowAir();
        flute.play();

        Harmonium harmonium = new Harmonium();
        harmonium.use();
        harmonium.blowAir();
        harmonium.play();
        harmonium.pump();

        // Testing Medical Instruments
        SurgicalCutter cutter = new SurgicalCutter();
        cutter.use();
        cutter.sterile();
        cutter.operate();
        cutter.cut();

        SurgicalNeedle needle = new SurgicalNeedle();
        needle.use();
        needle.sterile();
        needle.operate();
        needle.stitch();

        Glucometer glucometer = new Glucometer();
        glucometer.use();
        glucometer.reader();
        glucometer.operate();
        glucometer.bloodSample();

        ECGMachine ecgMachine = new ECGMachine();
        ecgMachine.use();
        ecgMachine.reader();
        ecgMachine.operate();
        ecgMachine.setup();
    }
}

interface Instrument
{
	void use(); //by default method is public and abstract
}

//----------------------------------------------------------
abstract class MusicalInstrument implements Instrument
{
	abstract void play();
}
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneStrings();
}

abstract class AirBasedInstruments extends MusicalInstrument
{
	abstract void blowAir();
}

class Guitar extends StringBasedMusicalInstrument{
	public void use() {
		System.out.println("Using Guitar...");
	}
	void play() {
		System.out.println("Playing Guitar...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Guitar...");

	}
	void pluck() {
		System.out.println("Plucking Strings of Guitar...");

	}
}


class Violin extends StringBasedMusicalInstrument{
	public void use() {
		System.out.println("Using Violin...");
	}
	void play() {
		System.out.println("Playing Violin...");

	}
	void tuneStrings() {
		System.out.println("Tuning Strings of Violin...");

	}
	void bow() {
		System.out.println("Bowing Strings of Violin...");

	}
}
class Flute extends AirBasedInstruments{
	public void use() {
		System.out.println("Using flute...");
	}
	public void blowAir() {
		System.out.println("Blowing air into flute");
	}
	public void play() {
		System.out.println("playing flute....");
	}
	public void adjustingHeadJoint() {
		System.out.println("adjusting the head joint of Head Joint");
	}
}
class Harmonium extends AirBasedInstruments{
	public void use() {
		System.out.println("Using Harmonium...");
	}
	public void blowAir() {
		System.out.println("Blowing air into Harmonium");
	}
	public void play() {
		System.out.println("playing Harmonium....");
	}
	public void pump() {
		System.out.println("pumping the harmonium");
	}
}

//-----------------------------------------------------------------------------------------------

abstract class MedicalInstrument implements Instrument
{
	abstract void operate();
}
abstract class SurgicalInstrument extends MedicalInstrument
{
	abstract void sterile();
}

abstract class PathologicalInstruments extends MedicalInstrument
{
	abstract void reader();
}
//SurgicalCutter  SurgicalNeedle Glucometer   ECGMachine
class SurgicalCutter extends SurgicalInstrument {

	public void use() {
		System.out.println("using surgical cutter");
	}

	void sterile() {
		System.out.println("sterlizing the surgical cutter");
		
	}

	void operate() {
		System.out.println("Operating using surgical cutter");
		
	}
		
	void cut() {
		System.out.println("cutting open the body");
	}
}

class SurgicalNeedle extends SurgicalInstrument {

	public void use() {
		System.out.println("using surgical needle");
	}

	void sterile() {
		System.out.println("sterlizing the surgical needle");
		
	}

	void operate() {
		System.out.println("Operating using surgical needle");
		
	}
		
	void stitch() {
		System.out.println("stiching up the body");
	}
}

class Glucometer extends PathologicalInstruments {

	public void use() {
		System.out.println("using Glucometer");
	}

	void reader() {
		System.out.println("reading the glucometer reading");
		
	}

	void operate() {
		System.out.println("operating the glucometer device");
		
	}
		
	void bloodSample() {
		System.out.println("taking blood sample for glucometer");
	}
	
}
class ECGMachine extends PathologicalInstruments {

	public void use() {
		System.out.println("using ECGMachine");
	}

	void reader() {
		System.out.println("reading the ECGMachine reading");
		
	}

	void operate() {
		System.out.println("operating the ECGMachine device");
		
	}
		
	void setup() {
		System.out.println("seting up the ECG machine");
	}
	
}