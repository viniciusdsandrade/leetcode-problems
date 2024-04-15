#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* createNode(int val) {
    struct ListNode *node = (struct ListNode *) malloc(sizeof(struct ListNode));
    node->val = val;
    node->next = NULL;
    return node;
}

struct ListNode* mergeTwoLists(struct ListNode *list1, struct ListNode *list2) {
    struct ListNode *dummy = createNode(-1);
    struct ListNode *current = dummy;

    while (list1 != NULL && list2 != NULL) {
        if (list1->val < list2->val) {
            current->next = list1;
            list1 = list1->next;
        } else {
            current->next = list2;
            list2 = list2->next;
        }
        current = current->next;
    }

    current->next = list1 ? list1 : list2;

    struct ListNode *head = dummy->next;
    free(dummy);
    return head;
}

void printLinkedList(struct ListNode *head) {
    printf("[");
    while (head != NULL) {
        printf("%d", head->val);
        if (head->next != NULL)
            printf(" -> ");
        head = head->next;
    }
    printf("]\n");
}

void testMergeTwoLists(struct ListNode *list1, struct ListNode *list2) {
    printf("List 1: ");
    printLinkedList(list1);
    printf("List 2: ");
    printLinkedList(list2);

    struct timespec start, end;
    clock_gettime(CLOCK_MONOTONIC, &start);
    struct ListNode *result = mergeTwoLists(list1, list2);
    clock_gettime(CLOCK_MONOTONIC, &end);

    printf("Result: ");
    printLinkedList(result);

    double runtimeNanoSeconds = end.tv_nsec - start.tv_nsec;
    printf("Execution time: %.0lf ns\n", runtimeNanoSeconds);
}

int main(void) {
    struct ListNode *list1 = createNode(1);
    list1->next = createNode(2);
    list1->next->next = createNode(4);

    struct ListNode *list2 = createNode(1);
    list2->next = createNode(3);
    list2->next->next = createNode(4);

    testMergeTwoLists(list1, list2);

    return 0;
}
