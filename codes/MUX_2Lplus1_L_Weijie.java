package YaoGC;
public class MUX_2Lplus1_L_Weijie extends CompositeCircuit
{
	private final int L;
	public MUX_2Lplus1_L_Weijie(int L)
	{
		super(2*L+1, L, L, "MUX_2Lplus1_L_2*L+1");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1] = new MUX_3_1();
		}
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*2+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[2*L+i*0+0].connectTo(subCircuits[0+i*1].inputWires, 2);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[1+i*2+0].connectTo(subCircuits[0+i*1].inputWires, 0);
		}
	}
	protected void defineOutputWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			outputWires[0+i*1+0] = subCircuits[0+i*1].outputWires[0];
		}
	}
	protected void fixInternalWires() 
	{
	}
}
