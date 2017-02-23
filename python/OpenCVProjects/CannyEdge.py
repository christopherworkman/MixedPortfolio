import cv2
import numpy as np
from matplotlib import pyplot as plt

imname = 'images/strawberry-leaf.jpg'
img = cv2.imread(imname, 0)

lpc = cv2.Laplacian(img, cv2.CV_8U)
edges = cv2.Canny(lpc, 120, 150)

plt.subplot(131), plt.imshow(img, cmap = 'gray')
plt.title('Original Image'), plt.xticks([]), plt.yticks([])
plt.subplot(132),plt.imshow(lpc, cmap='gray')
plt.title('Laplacian Image'), plt.xticks([]), plt.yticks([])
plt.subplot(133),plt.imshow(edges, cmap='gray')
plt.title('Edge Image'),plt.xticks([]), plt.yticks([])

plt.show()