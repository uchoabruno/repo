Ext.application({
    name: 'Sencha',

    launch: function() {
        Ext.create("Ext.tab.Panel", {
            fullscreen: true,
            items: [
                {
                    title: 'Wohoo',
                    iconCls: 'home',
                    html: [
                           "I changed the default <b>HTML Contents</b> to something different!"
                       ].join("")
                }
            ]
        });
    }
});