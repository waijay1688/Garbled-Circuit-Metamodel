package YaoGC;
public class GT_2L_1 extends CompositeCircuit
{
	private final int L;
	public GT_2L_1(int L)
	{
		super(2*L, 1, L, "GT_2L_1_2*L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1] = new GT_3_1();
		}
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[1+i*2+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*2+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L-1; i=i+1)
		{
			subCircuits[0+i*1].outputWires[0].connectTo(subCircuits[1+i*1].inputWires, 2);
		}
	}
	protected void defineOutputWires() 
	{
		outputWires[0+0] = subCircuits[L-1].outputWires[0+0];
	}
	protected void fixInternalWires() 
	{
		subCircuits[0].inputWires[0+2].fixWire(0);
	}
}
