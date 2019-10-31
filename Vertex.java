package mlc.components;

import java.util.ArrayList;

public class Vertex
{

	private ArrayList<Region> regions;
	private ArrayList<Edge> edges;
	private boolean selected, root, leaf, finalized;
	private int degree = 0;
	private int weight = 0;
	private final int id, depth;

	public Vertex(int d, int id)
	{
		depth = d;
		root = false;
		leaf = false;
		finalized = false;
		this.id = id;
	}

	public ArrayList<Region> getRegions()
	{
		return regions;
	}

	public boolean getFinalized()
	{
		return finalized;
	}

	public boolean getLeaf()
	{
		return leaf;
	}

	public boolean getRoot()
	{
		return root;
	}

	public int getDegree()
	{
		return degree;
	}

	public int getID()
	{
		return id;
	}

	public boolean getSelected()
	{
		return selected;
	}

	public int getDepth()
	{
		return depth;
	}

	public int getWeight()
	{
		return weight;
	}

	public ArrayList<Edge> getEdges()
	{
		return edges;
	}

	public void incDegree()
	{
		degree++;
	}

	public void setRegion(Region r)
	{
		regions.add(r);
	}

	public void setWeight(int w)
	{
		weight = w;
	}

	public void setSelected()
	{
		if(selected == false)
		{
			selected = true;
		}
	}

	public void setLeaf()
	{
		leaf = !leaf;
	}

	public void setRoot()
	{
		root = !root;
	}

	public void setFinalized()
	{
		finalized = !finalized;
	}

	public void setEdge(Edge e)
	{
		edges.add(e);
	}

	public String toString()
	{
		return("ID: " + id + ", Depth: " + depth + ", Degree:" + degree);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + degree;
		result = prime * result + depth;
		result = prime * result + (finalized ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (leaf ? 1231 : 1237);
		result = prime * result + (root ? 1231 : 1237);
		result = prime * result + (selected ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if(degree != other.degree)
			return false;
		if(depth != other.depth)
			return false;
		if(finalized != other.finalized)
			return false;
		if(id != other.id)
			return false;
		if(leaf != other.leaf)
			return false;
		if(root != other.root)
			return false;
		if(selected != other.selected)
			return false;
		return true;
	}

}
