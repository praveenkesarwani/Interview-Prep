<h2>1-Prefix Sum</h2>
<h4>What is Prefix Sum?</h4>
<p>
<ul>
    <li>For every element arr[i], we generate the <b>sum of all elements from 0 to i.</b> We store these values and it is useful in solving such problems.</li>
    <li>This sum calculation is done in O(n) time by doing (current_sum = previous_sum + arr[i]).</li>
</ul>
</p>
<h3>How is Prefix Sum useful in solving the above problem(subarraySumZero)</h3>
<p>
    <ul>
        <li>If the Prefix Sum for any index in the array has been seen before or if the Prefix Sum is zero, we have a zero sum sub-array.</li>
        <li>Example 1: Array[5,3,-1,-1,-1,8]
            <ul>
                <li>Prefix Sum array[<b>5</b>,8,7,6,<b>5</b>,13]</li>
                <li>We see that 5 is seen before. This tells us that the sub-array[3,-1,-1,-1] is a subarray of sum 0.</li>
            </ul>
        </li>
        <li>Example 2: Array[-1,2,4,-3,-2,7]
            <ul>
                <li>Prefix Sum array[-1,1,5,2,<b>0</b>,7]</li>
                <li>We see a prefix sum of 0. this tells us that the preceding subarray[-1,2,4,-3,-2] sums to 0.</li>
            </ul>
        </li>
    </ul>
</p>
<h2>2-Heap Data Structure</h2>
<ul>
    <li>Heaps are the data structure that can <b>access the maximum or minimum element very quickly.</b> </li>
    <li>They are <b>implemented using arrays</b> (can also use linked list). the <b>Array Map</b> of Heap would like this </li>
    <img src = "heap.png" height="250px">
    <li>You will notice that the heap can be visualized as a <b>nearly complete binary tree</b></li>
    <li>Array Map
        <ul>
            <li>Root of the tree is the first element in the array corresponding to i = 1</li>
            <li>The parent of node i = i / 2 --> Index of parent node</li>
            <li>Left child of node i = 2 * i --> Index of left child</li>
            <li>Right child of node i = 2 * i  + 1--> Index of right child</li>
        </ul>
    </li>
</ul>
<p>Note: <i>We are using a Binary Heap here. There are other types as well.</i></p>
<h3>Max Heap and Min Heap</h3>
<p>In a Max Heap, the <b>value of the Parent is always greater than or equal to the value of it's child nodes</b></p>
<p>
    <ul>
        <li>To build a Max Heap, we call the <b>max_heapify</b> function which starts bottom up. It will compare and swap parent with it's child nodes to satisfy the above property. Doing this repeatedly till the root creates a Max Heap.</li>
        <li><b>Removal of node </b>is remval of the root node. Upon doing this we move the last heap node to root. compare this node to its children swap with the larger child till Max Heap property is satisfied.</li>
        <li><b>Insertion of node</b> is inserting the node at the end of the heap and swapping with the parent till it satisfies Max Heap property.</li>
    </ul>
</p>
<p>
In a Min Heap, the <b> value of the Parent is always lesser than or equal to the value of its child nodes</b>
<ul>
<li>Similar to Max Heap, but has a <b>min_heapify</b> which will work bottom up and swap parent and child nodes to satisfy the above property. </li>
</ul>  
</p>
<h3>Heaps and Priority Queues</h3>
<p><b>Heaps are naturally suited to implement Priority Queues </b> since Heap is a data structure where the nodes of the tree are priority based order.<br>
Example - Max Heap has largest element at root and Min Heap has smallest element at root.<br>
It stores data in a way that the first element with highest priority returned quickly.<br>
Heaps are preferred over other data structure to implement Priority Queue since they provide better performance.<br>
A binary heap can provide
<ul>
    <li>O(1) time getHighestPriority()</li>
    <li>O(log n) time insert()</li>
    <li>O(log n) time deleteHighestPriority()</li>
</ul>
</p>