/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
Note: There could be self loops.
Note: This is a directed graph.
*/
#include <bits/stdc++.h>
using namespace std;
//BFS Traversal
bool hasPath(list<int> adj_list[], bool *visited, int source, int destination)
{
    queue<int> pendingVertex;
    pendingVertex.push(source);
    // visited[source] = true;  to handle cyclic path
    while (!pendingVertex.empty())
    {
        int currentVertex = pendingVertex.front();
        pendingVertex.pop();
        //cout<<currentVertex<<" ";
        for (auto i = adj_list[currentVertex].begin(); i != adj_list[currentVertex].end(); i++)
        {
            if (*i == destination)
                return true;
            if (!visited[*i])
            {
                visited[*i] = true;
                pendingVertex.push(*i);
            }
        }
    }
    return false;
}

bool RouteBetweenNodes(int source, int destination, int numberofnodes, vector<vector<int>> edgelist)
{
    //convert edgeList to adjacency list
    list<int> adj_list[numberofnodes + 1];
    for (int i = 0; i < edgelist.size(); i++)
    {
        int u = edgelist[i][0];
        int v = edgelist[i][1];
        adj_list[u].push_back(v);
    }

    //To keep track of visited nodes
    bool *visited = new bool[numberofnodes + 1];
    for (int i = 0; i <= numberofnodes; i++)
    {
        visited[i] = false;
    }

    bool ans = hasPath(adj_list, visited, source, destination);
    if (ans)
        return true;
    delete[] visited; //delete explicitly
    return false;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int numberofnodes, edges;
        cin >> numberofnodes >> edges;
        int vertex1, vertex2;
        vector<vector<int>> edgelist;
        for (int i = 0; i < edges; i++)
        {
            cin >> vertex1 >> vertex2;
            vector<int> temp = {vertex1, vertex2};
            edgelist.push_back(temp);
        }
        int start, end;
        cin >> start >> end;
        bool result = RouteBetweenNodes(start, end, numberofnodes, edgelist);
        cout << ((result) ? "yes" : "no") << "\n";
    }
    return 0;
}
