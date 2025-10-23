#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function prototypes
void print_help();

int main(int argc, char *argv[]) {
    // Check argument count
    if (argc != 4) {
        print_help();
        return 1;
    }

    // Check for help flag
    if (strcmp(argv[1], "--help") == 0) {
        print_help();
        return 0;
    }

    // Extract arguments
    char *operation = argv[1];
    double num1 = atof(argv[2]);
    double num2 = atof(argv[3]);
    double result;

    // Perform operation
    if (strcmp(operation, "add") == 0) {
        result = num1 + num2;
    } else if (strcmp(operation, "sub") == 0) {
        result = num1 - num2;
    } else if (strcmp(operation, "mul") == 0) {
        result = num1 * num2;
    } else if (strcmp(operation, "div") == 0) {
        if (num2 == 0) {
            fprintf(stderr, "Error: Division by zero!\n");
            return 1;
        }
        result = num1 / num2;
    } else {
        fprintf(stderr, "Error: Unknown operation '%s'\n", operation);
        print_help();
        return 1;
    }

    // Display result
    printf("Result: %.2f\n", result);
    return 0;
}

// Function to print usage/help
void print_help() {
    printf("Simple CLI Calculator\n");
    printf("Usage:\n");
    printf("  calc <operation> <num1> <num2>\n\n");
    printf("Operations:\n");
    printf("  add   Addition\n");
    printf("  sub   Subtraction\n");
    printf("  mul   Multiplication\n");
    printf("  div   Division\n\n");
    printf("Example:\n");
    printf("  calc add 10 5\n");
    printf("  calc div 8 2\n");
}
