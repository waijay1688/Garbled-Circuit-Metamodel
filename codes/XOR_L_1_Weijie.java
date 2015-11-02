package YaoGC;
public class XOR_L_1_Weijie extends CompositeCircuit
{
	private final int L;
	public XOR_L_1_Weijie(int L)
	{
		super(L, 1, L-1, "XOR_L_1_L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L-1; i=i+1)
		{
			subCircuits[0+i*1] = new XOR_2_1();
		}
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		inputWires[0+0].connectTo(subCircuits[0].inputWires, 0+0);
		for( int i=0; i<L-1; i=i+1)
		{
			inputWires[1+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L-2; i=i+1)
		{
			subCircuits[1+i*1].outputWires[0].connectTo(subCircuits[1+i*1].inputWires, 0);
		}
	}
	protected void defineOutputWires() 
	{
		outputWires[0+0] = subCircuits[L-2].outputWires[0+0];
	}
	protected void fixInternalWires() 
	{
	}
}
