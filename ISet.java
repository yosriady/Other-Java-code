
public interface ISet {

	
	public boolean add(String name) throws Exception;
	
	public ISet intersection(ISet otherSet);
	
	public int size();
	
	public String[] enumerateSet();
	
	
	
	
	
}
