<h1>Spanning Tree:</h1>
<p>A spanning tree is a subset of Graph G, which has all the vertices covered with minimum possible number of edges.
Hence, a spanning tree does not have cycles and it cannot be disconnected.
<ul>
    <li>Connected</li>
    <li>Undirected</li>
    <li>No Cycle</li>
</ul>
</p>
<h1>Minimum Spanning Tree (MST)</h1>
<p>A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
<ul>
    <li>Weighted + Spanning Tree</li>
</ul>
</p>
<h1>Kruskal's Algorithm</h1>
<h3>Kruskal's Algorithm:</h3>
<p>sort the edges of G in increasing order based on weight<br>
keep a subgraph S of G, initially Empty<br>
for each edge e in sorted order<br>
&nbsp&nbsp&nbsp if adding e in S doesn't form a cycle<br>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp add e to S<br>
&nbsp&nbsp&nbsp else ignore e<br>
return S
<br>
<p><b>Union-Find Algorithm</b> can be used to check whether an undirected graph contains cycle or not.</p>
</p>

<h2>Prim's Algorithm</h2>Good Explanation<a href = "https://www.youtube.com/watch?v=ZtZaR7EcI5Y">click here</a>
<h2>Dijkstra Algorithm</h2>Good Explanation<a href = "https://www.youtube.com/watch?v=smHnz2RHJBY">click here</a>
