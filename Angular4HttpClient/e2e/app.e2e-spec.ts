import { Angular4HttpClientPage } from './app.po';

describe('angular4-httpclient App', () => {
  let page: Angular4HttpClientPage;

  beforeEach(() => {
    page = new Angular4HttpClientPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
