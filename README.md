# Paging-List
load data into recyclerview by paging: using paging library from jetpack


There are several example on this repository:
### [No Network](https://github.com/ANNASBlackHat/Paging-List/tree/no-network)
This is basic example, just using paging library to load dummy data (created by loop)


### [Network](https://github.com/ANNASBlackHat/Paging-List/tree/network)
Using retrofit to load data from server (public API)


### [Network Generic](https://github.com/ANNASBlackHat/Paging-List/tree/network-generic)
Because of creating paging need bunch of file, that's mean if we have many page need to load by paging, we have to create those files.
So I try to make paging function can be used in any view model which needed

### [Network State](https://github.com/ANNASBlackHat/Paging-List/tree/network-state)
On this example, we show progress bar at the bottom of page if the app is currently loading data from server, and remove it when  data is loaded.
The progress bar will always appears every time user scrolling to bottom and paging of the next page is triggered