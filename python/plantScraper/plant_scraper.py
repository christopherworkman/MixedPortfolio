from selenium import webdriver
import urllib2
import csv
from bs4 import BeautifulSoup

path_to_cd = '/Users/mariabocanegra/Desktop/chromedriver'
browser = webdriver.Chrome(executable_path = path_to_cd)

url='https://plants.usda.gov/checklist.html'
browser.get(url)




# <input name="searchTxt" type="text" class="searchformtext" id="searchfield" title="Enter a name or symbol. Use wild cards for partial name searches." size="40">


#checks in CA checkbox
browser.find_element_by_xpath('//*[@id="un_9"]').click()
browser.find_element_by_xpath('//*[@id="statesearch"]/p[3]/input[2]').click()
browser.find_element_by_xpath('//*[@id="statesearch"]/p[5]/input').click()

page=browser.page_source
# page=requests.get(browser.find_element_by_xpath('/html/body/table/tbody/tr[5]/td/table/tbody/tr/td[4]/table/tbody/tr[3]/td[1]/table').text)


soup=BeautifulSoup(page, "lxml")



sciList=[]


sci=(soup.find_all('td',class_="resultsind1"))
com=(soup.find_all('tr',class_="rowon"))

common = soup.find_all('tr',class_="rowon")
# com=common.find_all('td')[1::]

#successfully appends scientific names to sciList
for r in sci:
	rt =(r.text).encode('utf-8')
	sciList.append(rt)

# print sciList	


# prints each code value, scientific, and common name
# comList=[]
item = []
i=0
	

for com in common:
	for comN in com.find_all('td')[1::]:
		comt=comN.text		
		comtu = comt.replace(u'\xa0', u' ')
		comtu.encode('utf-8')# comList.append(comt)
		if i < len(sciList):
			item.append([comtu,sciList[i]])
			i+=1
# print comList


with open('plant_list.csv', 'w') as csvfile:
    writer = csv.writer(csvfile, delimiter=',')
    for i in item:
        writer.writerow(i)

