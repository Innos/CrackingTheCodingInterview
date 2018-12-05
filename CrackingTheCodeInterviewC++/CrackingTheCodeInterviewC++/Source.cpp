#include <iostream>
#include <string>

using namespace std;

void reverse(char* str);

int main() {

	string a("pesho");
	char* input = new char[a.length() + 1];
	//char* test = new char[a.length() + 1];
	//size_t len = a.copy(test, a.length() + 1);
	//*(test + len) = '\0';
	//cout << test << endl;

	strcpy(input, a.c_str());
	reverse(input);
	bool isTerminated = *(input + 5) == '\0';
	cout << isTerminated << endl;
	cout << input << endl;
	return 0;
}

void reverse(char* str) {
	char* end = str;
	char temp;

	if (str) {
		while (*end) {
			++end;
		}

		--end; //account for null separator
	}

	while (str < end) {
		temp = *str;
		*str++ = *end;
		*end-- = temp;
	}
}