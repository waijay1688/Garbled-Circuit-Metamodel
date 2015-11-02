package YaoGC;
public class XOR_2L_L_Weijie extends CompositeCircuit
{
	private final int L;
	public XOR_2L_L_Weijie(int L)
	{
		super(2*L, L, L, "XOR_2L_L_2*L");
		this.L = L;
	}
	protected void createSubCircuits() throws Exception 
	{
		for( int i=0; i<L; i=i+1)
		{
			subCircuits[0+i*1] = new XOR_2_1();
		}
		super.createSubCircuits();
	}
	protected void connectWires() 
	{
		for( int i=0; i<L; i=i+1)
		{
			inputWires[0+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 1);
		}
		for( int i=0; i<L; i=i+1)
		{
			inputWires[L+i*1+0].connectTo(subCircuits[0+i*1].inputWires, 0);
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
