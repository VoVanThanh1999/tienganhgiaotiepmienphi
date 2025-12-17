type MenuEntry = { labelId: string; link: string | string[] };

const MENU_ENTRIES: MenuEntry[] = [
  {
    labelId: 'welcome',
    link: '/welcome'
  },
  {
    labelId: 'jokes',
    link: ['/', 'jokes', 'chuck-norris']
  },
  {
    labelId: 'notFound',
    link: '/non-existent'
  },
  {
    labelId: 'acc',
    link: '/account'
  },

];

export { MENU_ENTRIES, MenuEntry };
