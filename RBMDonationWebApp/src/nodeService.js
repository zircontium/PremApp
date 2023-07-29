const Service =  require('node-windows').Service

const service = new Service({
    name:"RBMDonationWebApp",
    description: "desc",
    script: "E:\\Crieatazo\\RBMDonationWebApp\\src\\index.js"
})

service.on('install', function(){
    service.start()
})

service.install()
