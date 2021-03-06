package mlc.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Region
{

	private ArrayList<Edge> edges = new ArrayList<>();
	private HashSet<Vertex> vertices = new HashSet<Vertex>();
	private boolean covered, resolved, hold;
	private int id, depth;

	public Region(ArrayList<Edge> e, int id)
	{
		edges.addAll(e);
		for(Edge temp : edges)
		{
			vertices.add(temp.getVertices()[0]);
			vertices.add(temp.getVertices()[1]);
		}

		/*
		 * The depth of the region initially is set to 3. If there is a vertex with
		 * depth of 1, then the region is either depth 2 or 1. Thus, if the depth = 1
		 * after the first for loop, a single vertex not of depth 1 would mean the
		 * region is of depth 2.
		 */
		depth = 3;
		for(Vertex v : vertices)
		{
			if(v.getDepth() == 1)
			{
				depth = 1;
			}
		}
		if(depth == 1)
		{
			for(Vertex v : vertices)
			{
				if(v.getDepth() != 1)
				{
					depth = 2;
				}
			}
		}
		this.id = id;
		resolved = false;
		hold = false;
		Collections.sort(edges, (e1, e2) -> e1.getWeight() - e2.getWeight());
	}

	public Region(boolean covered, boolean resolved, boolean hold, int id, int depth, HashSet<Vertex> vertices, ArrayList<Edge> edges)
	{
		this.covered = covered;
		this.resolved = resolved;
		this.hold = hold;
		this.id = id;
		this.depth = depth;
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public Region copy()
	{
		return new Region(covered, resolved, hold, id, depth, vertices, edges);
	}
	
	public String toString()
	{
		return("ID:" + id + ", Depth: " + depth + ", Hold: " + hold + ", Covered: " + covered + ", Resolved: " + resolved + ", # of Edges: "
					+ edges.size());
	}

	public void setCovered(boolean b)
	{
		covered = b;
	}

	public void setHold(boolean b)
	{
		hold = b;
	}

	public void setResolved(boolean b)
	{
		resolved = b;
	}

	public boolean isHold()
	{
		return hold;
	}

	public int getID()
	{
		return id;
	}

	public int getDepth()
	{
		return depth;
	}

	public ArrayList<Edge> getEdges()
	{
		return edges;
	}

	public HashSet<Vertex> getVertices()
	{
		return vertices;
	}

	public boolean isCovered()
	{
		return covered;
	}

	public boolean isResolved()
	{
		return resolved;
	}

}
