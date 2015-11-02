package YaoGC;
public class EDT_2L_1 extends CompositeCircuit
{
	private final int L;
	public EDT_2L_1(int L)
	{
		super(2L, 1, L+1, "EDT_2L_1_2L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		subCircuits[L] = new OR_L_1(L);
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1] = XOR_2_1.newInstance();
		}
	}
	super.createSubCircuits();
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[L+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1].outputWires[0].connectTo(subCircuits[L].inputWires, 0+i*1+0);
		}
	}
	protected void defineOutputWires() 
	{
		outputWires[0+0] = subCircuits[0].outputWires[0+0];
	}
	protected void fixInternalWires() 
	{
	}
}
