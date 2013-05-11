import java.util.Iterator;

public class Block implements IBody{

	double weight;
	double length;
	double centerOfMass;

	public Block(double w, double l){
		this.weight = w;
		this.length = l;
		this.centerOfMass = l/2;
	}


	@Override
	public double getLength() {
		return this.weight;
	}


	@Override
	public double getCenterOfMass() {
		return this.centerOfMass;
	}


	@Override
	public double getMass() {
		return this.weight;
	}

	
	
	public static void main(String[] args) {
		Block a = new Block(1,1);
		
		System.out.println(a.getLength());
		System.out.println(a.getMass());
		System.out.println(a.getCenterOfMass());
		
	}


	@Override
	public Iterator<Block> iterator() {
		return new BlockIterator(this);
	}
	
	class BlockIterator implements Iterator<Block>{
		boolean queried = false;
		Block thisBlock;
		
		BlockIterator(Block t){
			thisBlock = t;
		}

		@Override
		public boolean hasNext() {
			return (!queried);
		}

		@Override
		public Block next() {
			
			if(!queried){
				queried = true;
				return thisBlock;
			} else {
				return null;
			}
			
			
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove not implemented.");
		}
		
	}
}
