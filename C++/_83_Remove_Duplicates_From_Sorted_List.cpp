#include <iostream>
#include <chrono>
#include <vector>

using namespace std;
using namespace std::chrono;

/*
    83. Remove Duplicates from Sorted List
    Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    Return the linked list sorted as well.

    Example 1:
    Input: head = [1,1,2]
    Output: [1,2]

    Example 2:
    Input: head = [1,1,2,3,3]
    Output: [1,2,3]

    Constraints:
    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.
 */

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    explicit ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    static ListNode *deleteDuplicates(ListNode *head) {
        ListNode *current = head;
        while (current != nullptr && current->next != nullptr) {
            if (current->val == current->next->val) {
                ListNode *temp = current->next;
                current->next = current->next->next;
                delete temp;
            } else {
                current = current->next;
            }
        }
        return head;
    }

    static ListNode *createLinkedList(vector<int> &values) {
        auto *dummy = new ListNode(0);
        ListNode *current = dummy;
        for (int value: values) {
            current->next = new ListNode(value);
            current = current->next;
        }
        ListNode *head = dummy->next;
        delete dummy;
        return head;
    }

    static void deleteLinkedList(ListNode *head) {
        while (head != nullptr) {
            ListNode *nextNode = head->next;
            delete head;
            head = nextNode;
        }
    }

    static void printLinkedList(ListNode *head) {
        if (head == nullptr) {
            cout << "[]";
            return;
        }

        cout << "[";
        while (head != nullptr) {
            cout << head->val;
            if (head->next != nullptr) {
                cout << " -> ";
            }
            head = head->next;
        }
        cout << "]";
    }
};


void testDeleteDuplicates(ListNode *head) {

    try {

        cout << "\nInput: ";
        Solution::printLinkedList(head);

        auto startTime = high_resolution_clock::now();
        ListNode *answer = Solution::deleteDuplicates(head);
        auto endTime = high_resolution_clock::now();
        auto duration = duration_cast<nanoseconds>(endTime - startTime);

        cout << "\nOutput: ";
        Solution::printLinkedList(answer);
        cout << "\nExecution time: " << duration.count() << " ns\n";

    } catch (const exception &e) {
        cerr << "Error in test: " << e.what() << endl;
    }
}

int main() {
    vector<int> values1 = {1, 1, 2};
    ListNode *head1 = Solution::createLinkedList(values1);

    vector<int> values2 = {1, 1, 2, 3, 3};
    ListNode *head2 = Solution::createLinkedList(values2);

    testDeleteDuplicates(head1);
    testDeleteDuplicates(head2);

    Solution::deleteLinkedList(head1);
    Solution::deleteLinkedList(head2);

    return 0;
}


