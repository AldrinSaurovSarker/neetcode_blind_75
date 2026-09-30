class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>();
        rightHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        leftHeap.offer(num);
        rightHeap.offer(leftHeap.poll());

        if (rightHeap.size() > leftHeap.size()) {
            leftHeap.offer(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        }
        return (double) (leftHeap.peek() + rightHeap.peek()) / 2;
    }
}
