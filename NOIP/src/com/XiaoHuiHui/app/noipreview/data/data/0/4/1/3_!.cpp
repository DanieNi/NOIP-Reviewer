#include <iostream>
#include <cstring>
using namespace std;

int count=0, weight[1001], a[7];
memset(weight, 0, sizeof(weight));
for (int x1=0; x1<=a[1]; x1++)
	for (int x2=0; x2<=a[2]; x2++)
		for (int x3=0; x3<=a[3]; x3++)
			for (int x4=0; x4<=a[4]; x4++)
				for (int x5=0; x5<=a[5]; x5++)
					for (int x6=0; x6<=a[6]; x6++)
					{
						int w=1*x1+2*x2+5*x3+10*x4+20*x5+50*x6;
						weight[w]++;
					}

for (int i=1; i<=1000; i++)
	if (weight[i]>0) count++;
cout<<count;
	