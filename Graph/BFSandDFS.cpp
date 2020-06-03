//BFS and DFS for undirected and disconnected graph
//nodes are from 0 to n-1
#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> createAdjacencyMatrix(int n){    
    vector<vector<int>> matrix;
    for(int i = 0; i < n;i++){
        vector<int>edges;
        for(int j = 0;j < n;j++){
            edges.push_back(0);
        }
        matrix.push_back(edges);
    }
    return matrix;
}
void printDFS(vector<vector<int>>matrix, bool* visited,int startVertex){
    cout<<startVertex<<" ";
    visited[startVertex] = true;
    for(int i = 0;i < matrix.size();i++){
        if(i == startVertex)
            continue;
        if(matrix[startVertex][i] == 1 && !visited[i])
            printDFS(matrix, visited, i);
    }
}

void printBFS(vector<vector<int>> matrix, bool* visited,int startVertex){
    int n = matrix.size();
    queue<int>pendingVertices;
    pendingVertices.push(startVertex);
    visited[startVertex] = true;
    while(!pendingVertices.empty()){
        int currentVertex = pendingVertices.front();
        pendingVertices.pop();
        cout<<currentVertex<<" ";
        for(int i = currentVertex;i < n;i++){
            if(matrix[currentVertex][i] == 1 && !visited[i]){
                pendingVertices.push(i);
                visited[i] = true;
            }
        }
    }
}

void DFS(vector<vector<int>> matrix){
    int n = matrix.size();
    //keep track of visited nodes
    bool* visited = new bool[n];
    for(int i = 0;i < n;i++){
        visited[i] = false;
    }
    for(int i = 0;i < n; i++){
        if(!visited[i])
            printDFS(matrix,visited,i);
    }
    delete []visited;
}
void BFS(vector<vector<int>> matrix){
    int n = matrix.size();
    //keep track of visited nodes
    bool* visited = new bool[n];
    for(int i = 0;i < n;i++){
        visited[i] = false;
    }
    for(int i = 0;i < n; i++){
        if(!visited[i])
            printBFS(matrix,visited,i);
    }
    delete []visited;
}
int main(){
    int V, E;
    cin>>V>>E;
    //crete an adjacency matrix of NxN size
    vector<vector<int>> matrix = createAdjacencyMatrix(V);
    //take input in pair of edges and insert it in adjacency matrix
    for(int i = 0;i < E;i++){
        int v1,v2;
        cin>>v1>>v2;
        matrix[v1][v2] = 1;
        matrix[v2][v1] = 1;
    }
    cout<<"BFS"<<" ";
    BFS(matrix);
    cout<<endl;
    cout<<"DFS"<<" ";
    DFS(matrix);
}